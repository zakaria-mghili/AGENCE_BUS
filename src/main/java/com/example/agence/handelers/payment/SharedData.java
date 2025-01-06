package com.example.agence.handelers.payment;

public class SharedData {
        // Static variables to make data accessible globally
        private String email;

        // Optionally, you can have instance-based variables
        //private String emailInstance;
        //private double price;

        // Constructor if needed (for instance-based variables)
        public SharedData(String emailInstance, double price) {
            this.email = emailInstance;
            //this.price = price;
        }

        // Getters and setters for instance-based data
        public String getEmailInstance() {
            return email;
        }

        public void setEmailInstance(String emailInstance) {
            this.email = emailInstance;
        }

        /*public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }*/
    
        // public void setPrice(double price) {
        //     this.price = price;
        // }
    
}
