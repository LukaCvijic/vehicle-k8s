package at.htlleonding.vehicle.control;

import at.htlleonding.vehicle.entity.Vehicle;
import at.htlleonding.vehicle.entity.VehicleDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

@ApplicationScoped
public class VehicleRepository {

    @Inject
    EntityManager em;

    public List<Vehicle> findAllByTypedQuery(){

        TypedQuery<Vehicle> query = em.createQuery("select v from Vehicle v", Vehicle.class);

        List<Vehicle> vehicles = query.getResultList();

        return vehicles;
    }

    public List<Vehicle> findAllByNamedQuery() {

        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findAll", Vehicle.class);

        return query.getResultList();
    }

    public List<Vehicle> findAllByNamedQueryWithParameters(String brand) {

        TypedQuery<Vehicle> query = em
                .createNamedQuery("Vehicle.findByBrand", Vehicle.class)
                .setParameter("brand", brand);

        return query.getResultList();
    }

    public List<Vehicle> findAllByNamedQueryWithPositionalParameters(String brand) {

        TypedQuery<Vehicle> query = em
                .createNamedQuery("Vehicle.findByBrandWithPositionParameter", Vehicle.class)
                .setParameter(1, brand);

        return query.getResultList();
    }

    public List<Vehicle> findAllByNativQuery() {

        TypedQuery<Vehicle> query = em
                .createNamedQuery("Vehicle.findNativeAll", Vehicle.class);

        return query.getResultList();
    }

    public List<VehicleDTO> findAllWithDTO() {

        TypedQuery<VehicleDTO> query = em
                .createQuery("select NEW at.htlleonding.vehicle.entity.VehicleDTO(v.brand, v.model) from Vehicle v", VehicleDTO.class);

        return query.getResultList();
    }
}
