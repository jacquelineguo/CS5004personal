package Problem2;

import java.util.ArrayList;
import java.util.Objects;

/**
 * AbstractGroup represents a group of people which can be a band.
 */
public abstract class AbstractGroup implements ICreators{
  protected String groupName;
  protected ArrayList<RecordingArtist> members;

  /**
   * Constructor for AbstractGroup class.
   * @param groupName - group name.
   * @param members - group members.
   */
  public AbstractGroup(String groupName, ArrayList<RecordingArtist> members) {
    this.groupName = groupName;
    this.members = members;
  }

  /**
   * Check whether a Creator is in the group.
   * @param creator - a creator can be artist.
   * @return true if the creator is found in the group, false otherwise.
   */
  public abstract boolean isCreatorEqual(ICreators creator);

  @Override
  public String toString() {
    return "AbstractGroup{" +
        "groupName='" + groupName + '\'' +
        ", members=" + members +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || this.getClass() != o.getClass()) {
      return false;
    }
    AbstractGroup that = (AbstractGroup) o;
    return Objects.equals(groupName, that.groupName) && Objects
        .equals(members, that.members);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groupName, members);
  }
}
