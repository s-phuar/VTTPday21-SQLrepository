package VTTPday21.workshop.model;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private int id;                             // ID column
    private Integer employeeId;                 // employee_id, can be null when using Integer
    private Integer customerId;                 // customer_id, can be null when using Integer
    private Date orderDate;                     // order_date, DATETIME
    private Date shippedDate;                   // shipped_date, DATETIME
    private Integer shipperId;                  // shipper_id, can be null
    private String shipName;                    // ship_name
    private String shipAddress;                 // ship_address, LONGTEXT
    private String shipCity;                    // ship_city
    private String shipStateProvince;           // ship_state_province
    private String shipZipPostalCode;           // ship_zip_postal_code
    private String shipCountryRegion;           // ship_country_region
    private BigDecimal shippingFee;             // shipping_fee, DECIMAL(19,4)
    private BigDecimal taxes;                   // taxes, DECIMAL(19,4)
    private String paymentType;                 // payment_type
    private Date paidDate;                      // paid_date, DATETIME
    private String notes;                       // notes, LONGTEXT
    private double taxRate;                     // tax_rate, DOUBLE
    private Byte taxStatusId;                   // tax_status_id, TINYINT(4), can be null
    private byte statusId;                      // status_id, TINYINT(4)

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public Integer getEmployeeId() {return employeeId;}
    public void setEmployeeId(Integer employeeId) {this.employeeId = employeeId;}
    public Integer getCustomerId() {return customerId;}
    public void setCustomerId(Integer customerId) {this.customerId = customerId;}
    public Date getOrderDate() {return orderDate;}
    public void setOrderDate(Date orderDate) {this.orderDate = orderDate;}
    public Date getShippedDate() {return shippedDate;}
    public void setShippedDate(Date shippedDate) {this.shippedDate = shippedDate;}
    public Integer getShipperId() {return shipperId;}
    public void setShipperId(Integer shipperId) {this.shipperId = shipperId;}
    public String getShipName() {return shipName;}
    public void setShipName(String shipName) {this.shipName = shipName;}
    public String getShipAddress() {return shipAddress;}
    public void setShipAddress(String shipAddress) {this.shipAddress = shipAddress;}
    public String getShipCity() {return shipCity;}
    public void setShipCity(String shipCity) {this.shipCity = shipCity;}
    public String getShipStateProvince() {return shipStateProvince;}
    public void setShipStateProvince(String shipStateProvince) {this.shipStateProvince = shipStateProvince;}
    public String getShipZipPostalCode() {return shipZipPostalCode;}
    public void setShipZipPostalCode(String shipZipPostalCode) {this.shipZipPostalCode = shipZipPostalCode;}
    public String getShipCountryRegion() {return shipCountryRegion;}
    public void setShipCountryRegion(String shipCountryRegion) {this.shipCountryRegion = shipCountryRegion;}
    public BigDecimal getShippingFee() {return shippingFee;}
    public void setShippingFee(BigDecimal shippingFee) {this.shippingFee = shippingFee;}
    public BigDecimal getTaxes() {return taxes;}
    public void setTaxes(BigDecimal taxes) {this.taxes = taxes;}
    public String getPaymentType() {return paymentType;}
    public void setPaymentType(String paymentType) {this.paymentType = paymentType;}
    public Date getPaidDate() {return paidDate;}
    public void setPaidDate(Date paidDate) {this.paidDate = paidDate;}
    public String getNotes() {return notes;}
    public void setNotes(String notes) {this.notes = notes;}
    public double getTaxRate() {return taxRate;}
    public void setTaxRate(double taxRate) {this.taxRate = taxRate;}
    public Byte getTaxStatusId() {return taxStatusId;}
    public void setTaxStatusId(Byte taxStatusId) {this.taxStatusId = taxStatusId;}
    public byte getStatusId() {return statusId;}
    public void setStatusId(byte statusId) {this.statusId = statusId;}


//   `id` INT(11) NOT NULL AUTO_INCREMENT,
//   `employee_id` INT(11) NULL DEFAULT NULL,
//   `customer_id` INT(11) NULL DEFAULT NULL,
//   `order_date` DATETIME NULL DEFAULT NULL,
//   `shipped_date` DATETIME NULL DEFAULT NULL,
//   `shipper_id` INT(11) NULL DEFAULT NULL,
//   `ship_name` VARCHAR(50) NULL DEFAULT NULL,
//   `ship_address` LONGTEXT NULL DEFAULT NULL,
//   `ship_city` VARCHAR(50) NULL DEFAULT NULL,
//   `ship_state_province` VARCHAR(50) NULL DEFAULT NULL,
//   `ship_zip_postal_code` VARCHAR(50) NULL DEFAULT NULL,
//   `ship_country_region` VARCHAR(50) NULL DEFAULT NULL,
//   `shipping_fee` DECIMAL(19,4) NULL DEFAULT '0.0000',
//   `taxes` DECIMAL(19,4) NULL DEFAULT '0.0000',
//   `payment_type` VARCHAR(50) NULL DEFAULT NULL,
//   `paid_date` DATETIME NULL DEFAULT NULL,
//   `notes` LONGTEXT NULL DEFAULT NULL,
//   `tax_rate` DOUBLE NULL DEFAULT '0',
//   `tax_status_id` TINYINT(4) NULL DEFAULT NULL,
//   `status_id` TINYINT(4) NULL DEFAULT '0',





}
