package be.technifutur.simon.mvc.repository;

import be.technifutur.simon.mvc.models.entity.Reservation;
import be.technifutur.simon.mvc.utils.EMFSharer;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepositoryImpl
    extends AbstractCrudRepository<Reservation, Long>
    implements ReservationRepository {

    public ReservationRepositoryImpl(EMFSharer emfSharer) {

        super(Reservation.class, emfSharer.createEntityManager());
    }

    @Override
    public void adaptID(Long id, Reservation entity) {
        entity.setId(id);
    }
}
