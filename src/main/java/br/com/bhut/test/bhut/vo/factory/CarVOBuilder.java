package br.com.bhut.test.bhut.vo.factory;

import br.com.bhut.test.bhut.vo.CarVO;

public class CarVOBuilder {

    private final CarVO carVO;

    public CarVOBuilder(CarVO carVO) {
        this.carVO = carVO;
    }

    public static CarVOBuilder builder() {
        return new CarVOBuilder(new CarVO());
    }

    public CarVOBuilder id(String id) {
        this.carVO.set_id(id);
        return this;
    }

    public CarVOBuilder title(String title) {
        this.carVO.setTitle(title);
        return this;
    }

    public CarVOBuilder brand(String brand) {
        this.carVO.setBrand(brand);
        return this;
    }

    public CarVOBuilder price(String price) {
        this.carVO.setPrice(price);
        return this;
    }

    public CarVOBuilder age(Integer age) {
        this.carVO.setAge(age);
        return this;
    }

    public CarVO build() {
        return this.carVO;
    }

}
