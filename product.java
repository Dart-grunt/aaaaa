package lab1ref;

public class product{
        private int id;
        private String name; 
        private String upc; 
        private String producer; 
        private double price; 
        private int shelfLife; 
        private int amount; 

        public product(int id, String name, String upc, String producer, double price, int shelfLife, int amount) {
            this.id = id;
            this.name = name;
            this.upc = upc;
            this.producer = producer;
            this.price = price;
            this.shelfLife = shelfLife;
            this.amount = amount;
        }

        // getters
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getUpc() {
            return upc;
        }

        public String getproducer() {
            return producer;
        }

        public double getPrice() {
            return price;
        }

        public int getShelfLife() {
            return shelfLife;
        }

        public int getamount() {
            return amount;
        }

        @Override
        public String toString() {
            return String.format("Product{id=%d, name='%s', UPC='%s', producer='%s', price=%.2f, shelfLife=%d, amount=%d}",
                id, name, upc, producer, price, shelfLife, amount);
        }
}
