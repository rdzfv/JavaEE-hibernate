package cn.xyy.po;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AddressEntity {
    private int addressId;
    private String detail;
    private String zipcode;
    private String phone;
    private String type;
    private Set customers = new HashSet(0);

    public int getAddressId() {
        return addressId;
    }
    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Set getCustomers() {
        return customers;
    }

    public void setCustomers(Set customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity that = (AddressEntity) o;
        return addressId == that.addressId &&
                Objects.equals(detail, that.detail) &&
                Objects.equals(zipcode, that.zipcode) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, detail, zipcode, phone, type);
    }
}
