package com.mycomp.products.domain.model;

public record Product( String sku, Float price, String description, String category) {
    public Float getDiscount(){
        if (this.sku().endsWith("5")){
            return 30F;
        }else{
            return switch (this.category()){
                case "Electronics" -> 15F;
                case "Home & Kitchen" -> 25F;
                default -> null;
            };
        }
    }
}
