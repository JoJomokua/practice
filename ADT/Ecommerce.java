package ADT;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * CORE LOGIC
 * blueprints for products, carts, and orders.
 */

class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " (Ksh " + price + ")";
    }
}

class ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        items.add(product);
    }

    public void removeProduct(int index) {
        // to prevent system from crashing when nothing is  added
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    public double getTotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getPrice();
        }
        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public List<Product> getItems() {
        return new ArrayList<>(items); // Returning a copy to keep the original list safe
    }

    public void clearCart() {
        items.clear();
    }
}

class Order {
    private static int counter = 1;
    private int orderId;
    private List<Product> products;
    private double totalAmount;

    public Order(List<Product> products) {
        this.orderId = counter++;
        this.products = products;
        calculateTotal();
    }

    private void calculateTotal() {
        totalAmount = 0;
        for (Product p : products) {
            totalAmount += p.getPrice();
        }
    }

    public double getTotalAmount() { return totalAmount; }
    public int getOrderId() { return orderId; }

    @Override
    public String toString() {
        return "Order #" + orderId + " | Items: " + products.size() + " | Total: Ksh " + totalAmount;
    }
}

/**
 * Handles the flow of orders using a Queue (first come, first served)
 * and a Stack (so we can see the most recent completed orders first).
 */
class OrderManager {
    private Queue<Order> orderQueue = new LinkedList<>();
    private Stack<Order> orderHistory = new Stack<>();

    public void placeOrder(Order order) {
        orderQueue.add(order);
    }

    public Order processOrder() {
        if (orderQueue.isEmpty()) return null;

        Order order = orderQueue.poll();
        orderHistory.push(order); // Push to stack so the latest finished order is "on top"
        return order;
    }

    public Object[] getQueueArray() { return orderQueue.toArray(); }
    public Object[] getHistoryArray() { return orderHistory.toArray(); }
}

/**
 * THE USER INTERFACE

 *
 */
public class Ecommerce extends JFrame {

    //splitting into different tabs
    private Map<String, Product> catalog = new HashMap<>();
    private ShoppingCart cart = new ShoppingCart();
    private OrderManager orderManager = new OrderManager();

    // UI elements
    private JTable productTable;
    private JTable cartTable;
    private JLabel totalLabel;
    private JList<Object> queueList;
    private JList<Object> historyList;
    private DefaultTableModel cartModel;
    private DefaultListModel<Object> queueModel;
    private DefaultListModel<Object> historyModel;

    public Ecommerce() {
        setupCatalog();

        setTitle("My Simple E-Commerce App");
        setSize(850, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Shop", createStorePanel());
        tabbedPane.addTab("My Cart", createCartPanel());
        tabbedPane.addTab("Admin Dashboard", createAdminPanel());

        add(tabbedPane);
    }

    // inventory implementation
    private void setupCatalog() {
        catalog.put("P1", new Product("P1", "Laptop", 75000));
        catalog.put("P2", new Product("P2", "Smartphone", 45000));
        catalog.put("P3", new Product("P3", "Headphones", 5000));
        catalog.put("P4", new Product("P4", "Smart Watch", 12000));
        catalog.put("P5", new Product("P5", "Tablet", 30000));
    }
    // STORE TAB
    private JPanel createStorePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"ID", "Item Name", "Price (Ksh)"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };

        for (Product p : catalog.values()) {
            model.addRow(new Object[]{p.getId(), p.getName(), p.getPrice()});
        }

        productTable = new JTable(model);
        panel.add(new JScrollPane(productTable), BorderLayout.CENTER);

        JButton addButton = new JButton("Add Selected to Cart");
        addButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        addButton.addActionListener(e -> addToCart());

        JPanel btnPanel = new JPanel();
        btnPanel.add(addButton);
        panel.add(btnPanel, BorderLayout.SOUTH);

        return panel;
    }

    //  CART TAB
    private JPanel createCartPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] columns = {"ID", "Item Name", "Price (Ksh)"};
        cartModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) { return false; }
        };

        cartTable = new JTable(cartModel);
        panel.add(new JScrollPane(cartTable), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        JPanel infoPanel = new JPanel();
        totalLabel = new JLabel("Cart Total: Ksh 0.0");
        totalLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        infoPanel.add(totalLabel);

        JPanel btnPanel = new JPanel();
        JButton removeButton = new JButton("Remove Selected");
        JButton checkoutButton = new JButton("Checkout");

        removeButton.addActionListener(e -> removeFromCart());
        checkoutButton.addActionListener(e -> checkout());

        btnPanel.add(removeButton);
        btnPanel.add(checkoutButton);

        bottomPanel.add(infoPanel);
        bottomPanel.add(btnPanel);
        panel.add(bottomPanel, BorderLayout.SOUTH);

        return panel;
    }

    //  ADMIN TAB (Queue & Stack visualization)
    private JPanel createAdminPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2, 10, 10));

        // LEFT: The Queue
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.setBorder(BorderFactory.createTitledBorder("Orders to Process (Queue)"));
        queueModel = new DefaultListModel<>();
        queueList = new JList<>(queueModel);
        leftPanel.add(new JScrollPane(queueList), BorderLayout.CENTER);

        JButton processButton = new JButton("Process Next Order");
        processButton.addActionListener(e -> processOrder());
        leftPanel.add(processButton, BorderLayout.SOUTH);

        // RIGHT: The Stack
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Finished Orders (Stack)"));
        historyModel = new DefaultListModel<>();
        historyList = new JList<>(historyModel);
        rightPanel.add(new JScrollPane(historyList), BorderLayout.CENTER);

        panel.add(leftPanel);
        panel.add(rightPanel);

        return panel;
    }

    // BUTTON LOGIC

    private void addToCart() {
        int row = productTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select an item first!");
            return;
        }

        String id = (String) productTable.getValueAt(row, 0);
        Product p = catalog.get(id);
        cart.addProduct(p);
        refreshCartView();
    }

    private void removeFromCart() {
        int row = cartTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pick an item to remove.");
            return;
        }

        cart.removeProduct(row);
        refreshCartView();
    }

    private void checkout() {
        if (cart.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Your cart is empty, go shopping!");
            return;
        }

        Order order = new Order(cart.getItems());
        orderManager.placeOrder(order);

        cart.clearCart();
        refreshCartView();
        refreshAdminView();

        JOptionPane.showMessageDialog(this, "Success! Order #" + order.getOrderId() + " is now in the queue.");
    }

    private void processOrder() {
        Order done = orderManager.processOrder();
        if (done == null) {
            JOptionPane.showMessageDialog(this, "No orders left to process.");
        } else {
            refreshAdminView();
        }
    }

    // UI REFRESH METHODS

    private void refreshCartView() {
        cartModel.setRowCount(0);
        for (Product p : cart.getItems()) {
            cartModel.addRow(new Object[]{p.getId(), p.getName(), p.getPrice()});
        }
        totalLabel.setText("Cart Total: Ksh " + cart.getTotal());
    }

    private void refreshAdminView() {
        queueModel.clear();
        for (Object o : orderManager.getQueueArray()) {
            queueModel.addElement(o);
        }

        historyModel.clear();
        Object[] history = orderManager.getHistoryArray();
        // Showing history in reverse so the newest processed order is at the top
        for (int i = history.length - 1; i >= 0; i--) {
            historyModel.addElement(history[i]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Ecommerce().setVisible(true));
    }
}