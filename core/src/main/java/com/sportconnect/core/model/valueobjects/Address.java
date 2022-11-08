package com.sportconnect.core.model.valueobjects;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

public class Address {
    private String street1;
    private String street2;
    private String city;
    private String province;
    private String postalCode;

    private Address() {
    }

    public Address(String street1, String street2, String city, String province, String postalCode) {
        this.street1 = street1;
        this.street2 = street2;
        this.city    = city;
        this.province   = province;
        this.postalCode  = postalCode;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getStreet1()               { return street1;         }
    public void   setStreet1(String street1) { this.street1 = street1; }
    public String getStreet2()               { return street2;         }
    public void   setStreet2(String street2) { this.street2 = street2; }
    public String getCity()                  { return city;            }
    public void   setCity(String city)       { this.city = city;       }
    public String getProvince()                 { return province;           }
    public void   setProvince(String province)     { this.province = province;     }
    public String getPostalCode()                   { return postalCode;             }
    public void   setPostalCode(String postalCode)         { this.postalCode = postalCode;         }

    public static Builder newBuilder() {
        Address address = new Address();
        return new Builder(address);
    }

    public static class Builder {
        private Address address;

        public Builder(Address address) {
            this.address = address;
        }

        public Builder setStreet1(String street1) {
            address.setStreet1(street1);
            return this;
        }

        public Builder setStreet2(String street2) {
            address.setStreet2(street2);
            return this;
        }

        public Builder setProvince(String province) {
            address.setProvince(province);
            return this;
        }

        public Builder setCity(String city) {
            address.setCity(city);
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            address.setPostalCode(postalCode);
            return this;
        }

        public Address build() {
            return this.address;
        }
    }
}
