package restaurant;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "dishes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dishes {

    @XmlElement(name = "dish")
    private List<dish> dishes = new ArrayList<dish>();

    public List<dish> getDishes() {
        return dishes;
    }

    public void addDish(dish d){
        dishes.add(d);
    }

    public float calculatePrice(){

        float TotalPrice=0;
        for (dish plate : dishes)
            TotalPrice+=plate.getPrice()*plate.getQuantity();

        return TotalPrice;
    }

    public float calculatePriceWithTaxes(){
        float TotalWithTaxes=0;
        for (dish plate : dishes)
            TotalWithTaxes+=plate.getPriceWithTaxe()*plate.getQuantity();
        return TotalWithTaxes;
    }



}


