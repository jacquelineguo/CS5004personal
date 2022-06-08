package Problem2;

import java.util.ArrayList;

/**
 * Band class represents a music band.
 */
public class Band extends AbstractGroup{

  /**
   * Constructor of Band class.
   * @param bandName - the band's name.
   * @param members - the band's members which is a ArrayList.
   */
  public Band(String bandName, ArrayList<RecordingArtist> members) {
    super(bandName, members);
  }

  /**
   * Check if the creator in the member list of the band.
   * @param creator - a creator can be artist.
   * @return true if it contains, false otherwise.
   */
  @Override
  public boolean isCreatorEqual(ICreators creator) {
    return this.members.contains(creator);
  }

  @Override
  public String toString() {
    return "Band{" +
        "groupName='" + groupName + '\'' +
        ", members=" + members +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
