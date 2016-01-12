package beans;

public interface Crud {
  boolean addRecord();
  boolean deleteRecord(int id);
  boolean updateRecord(int id, String... args);
}
