package beans;

public interface TeammateBase {
  boolean addTeammate();
  boolean deleteTeammate(int id);
  boolean updateTeammate(int id, String... args);
}
