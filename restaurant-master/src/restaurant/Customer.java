package restaurant;

public class Customer {
    private static String Name;
    private static int reservedTableNo=0;
//    private static int orderNumber=0;
    private static Order order;
//    private List<Order> orders;
    public static String getName() {
        return Name;
    }

    public static void setName(String name) {
        Name = name;
    }
    public static void reserveTable(int table){
        reservedTableNo=table;
    }
    public static void MakeOrder(Dishes dishes, float totalCheck ){
        order = new Order(reservedTableNo, getName(), dishes, totalCheck );
//       TODO: saveorder
    }
    public static void printOrder() {
        System.out.println("Hi, "+order.getCustomerName()+"\nin table "+(order.getTableNumber()+1)+"\ndishes are :\n"+"price is "+order.getTotalCheck());
        for (dish plates : order.getDishes().getDishes()){
            System.out.println("dish name = "+plates.getName()+"\ndish quantity = "+plates.getQuantity());
        }
    }
}