package Problem1;

import java.util.Objects;

public class ContactInfo {
  private Name name;
  private String streetAndNumber;
  private String city;
  private String state;
  private String ZIPCode;
  private String phoneNumber;
  private String emailAddress;
  private Name emergencyContact;

  public ContactInfo(Name name, String streetAndNumber, String city,
      String state, String ZIPCode, String phoneNumber,
      String emailAddress, Name emergencyContact) {
    this.name = name;
    this.streetAndNumber = streetAndNumber;
    this.city = city;
    this.state = state;
    this.ZIPCode = ZIPCode;
    this.phoneNumber = phoneNumber;
    this.emailAddress = emailAddress;
    this.emergencyContact = emergencyContact;
  }

  public Name getName() { return this.name; }

  public String getStreetAndNumber() {
    return this.streetAndNumber;
  }

  public String getCity() {
    return this.city;
  }

  public String getState() {
    return this.state;
  }

  public String getZIPCode() {
    return this.ZIPCode;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public String getEmailAddress() {
    return this.emailAddress;
  }

  public Name getEmergencyContact() {return this.emergencyContact;}

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ContactInfo)) return false;
    ContactInfo that = (ContactInfo) o;
    return Objects.equals(getName(), that.getName()) &&
        Objects.equals(getStreetAndNumber(), that.getStreetAndNumber()) &&
        Objects.equals(getCity(), that.getCity()) &&
        Objects.equals(getState(), that.getState()) &&
        Objects.equals(getZIPCode(), that.getZIPCode()) &&
        Objects.equals(getPhoneNumber(), that.getPhoneNumber()) &&
        Objects.equals(getEmailAddress(), that.getEmailAddress()) &&
        Objects.equals(getEmergencyContact(), that.getEmergencyContact());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getStreetAndNumber(), getCity(),
        getState(), getZIPCode(), getPhoneNumber(), getEmailAddress(), getEmergencyContact());
  }
}
