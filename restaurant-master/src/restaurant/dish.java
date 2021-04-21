package restaurant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dish")
@XmlAccessorType(XmlAccessType.FIELD)
public class dish {

    @XmlElement(name = "name")
    private String name;

    @XmlElement(name = "price")
    private float price;

    @XmlElement(name = "type")
    private String type;

    private int quantity=0;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public float getPriceWithTaxe(){
        switch (type){
            case "appetizer":
                return price*1.1f;
            case "main_course":
                return price*1.15f;
            case "desert":
                return price*1.2f;
        }
        return 0;
    }

    public String getType() {
        return type;
    }
}