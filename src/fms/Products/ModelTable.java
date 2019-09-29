/*
$This Project is Licenced to Ubed Shaikh, Kanchan Jogi, Shubhangi Kamale.
$Source code is not editable without permission of anyone mentioned above.
$Project under Development.
$Copyright to Friends Microsoftwares 2018.
 */
package fms.Products;

/**
 *
 * @author ubed
 */
public class ModelTable {

    String pcode, manufacturer, model, colour, price;

    public String getColour() {
        return colour;
    }

    public ModelTable(String pcode, String manufacturer, String model, String colour, String price) {
        this.pcode = pcode;
        this.manufacturer = manufacturer;
        this.model = model;
        this.colour = colour;
        this.price = price;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
