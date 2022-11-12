package uci.tesis.carlostesis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uci.tesis.carlostesis.entity.Connector;

import java.util.List;

@Repository
public interface ConnectorRepository extends JpaRepository<Connector,Integer> {
    List<Connector> findAllByInfoContainingAndVendorIdContainingAndVendorErrorCodeContaining(
            String info,String vendorId,String vendorErrorCode
    );
}
