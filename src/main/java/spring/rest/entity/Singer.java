package spring.rest.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "singer")
public class Singer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;
    @Version
    @Column(name = "version")
    private int version;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "singer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Album> albums = new HashSet<>();
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "singer_instrument", joinColumns = @JoinColumn(name = "singer_id"), inverseJoinColumns = @JoinColumn(name = "instrument_id"))
    private Set<Instrument> instruments = new HashSet<>();

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public Set<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(Set<Instrument> instruments) {
        this.instruments = instruments;
    }

    @Override
    public String toString() {
        return "Singer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", version=" + version +
                '}';
    }
}
