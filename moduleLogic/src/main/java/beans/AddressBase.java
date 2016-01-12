package beans;

public interface AddressBase {
    boolean addAddress();
    boolean deleteAddress(int id);
    boolean updateAddress(int id, String... args);
}
