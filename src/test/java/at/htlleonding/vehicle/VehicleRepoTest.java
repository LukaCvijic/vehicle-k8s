package at.htlleonding.vehicle;

import at.htlleonding.vehicle.control.VehicleRepository;
import at.htlleonding.vehicle.entity.Vehicle;
import at.htlleonding.vehicle.entity.VehicleDTO;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@QuarkusTest
public class VehicleRepoTest {

    /*
    @Inject
    VehicleRepository vehicleRepository;

    @Test
    public void listAllVehiclesByTypedQuery() {
        List<Vehicle> vehicles = vehicleRepository.findAllByTypedQuery();

        System.out.println(vehicles);

        assertThat(vehicles).hasSize(7)
                .extracting(Vehicle::getBrand)
                .contains("Opel", "VW", "Audi", "BMW", "Mercedes");
    }

    @Test
    public void listAllVehiclesByNamedQuery() {
        List<Vehicle> vehicles = vehicleRepository.findAllByNamedQuery();

        System.out.println(vehicles);

        assertThat(vehicles).hasSize(7)
                .extracting(Vehicle::getBrand)
                .contains("Opel", "VW", "Audi", "BMW", "Mercedes");
    }

    @Test
    public void listAllVehiclesByNamedQueryWithParameters() {
        List<Vehicle> vehicles = vehicleRepository.findAllByNamedQueryWithParameters("Audi");

        System.out.println(vehicles);

        assertThat(vehicles).hasSize(2)
                .extracting(Vehicle::getBrand)
                .containsExactly("Audi", "Audi");
    }

    @Test
    public void listAllVehiclesByNamedQueryWithPositionalParameters() {
        List<Vehicle> vehicles = vehicleRepository.findAllByNamedQueryWithPositionalParameters("Audi");

        System.out.println(vehicles);

        assertThat(vehicles).hasSize(2)
                .extracting(Vehicle::getBrand)
                .containsExactly("Audi", "Audi");
    }

    @Test
    public void listAllVehiclesNative() {
        List<Vehicle> vehicles = vehicleRepository.findAllByNativQuery();

        System.out.println(vehicles);

        assertThat(vehicles).hasSize(7)
                .extracting(Vehicle::getBrand)
                .contains("Opel", "VW", "Audi", "BMW", "Mercedes");
    }

    @Test
    public void listAllDTOs() {
        List<VehicleDTO> vehicles = vehicleRepository.findAllWithDTO();

        System.out.println(vehicles);

        assertThat(vehicles).hasSize(7)
                .extracting(VehicleDTO::brand)
                .contains("Opel", "VW", "Audi", "BMW", "Mercedes");
    }

     */
}