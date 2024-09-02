package br.com.blz.testjava.data.request;

import javax.validation.constraints.NotNull;

public class CreateProductRequest extends ProductRequest{

    @NotNull(message = "O campo 'sku' é obrigatório")
    private Long sku;

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }
}
