package be.technifutur.simon.mvc.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public final class EMFSharer {

    // region SINGLETON
    private static EMFSharer instance;
    private final EntityManagerFactory emf;

    public static EMFSharer getInstance() {
        return instance == null ? instance = new EMFSharer() : instance;
//        if( instance == null ){
//            instance = new EMFSharer();
//        }
//
//        return instance;
    }
    private EMFSharer() {
        this.emf = Persistence.createEntityManagerFactory("hotel-manager");
    }
    // endregion



    public EntityManagerFactory getEmf() {
        return emf;
    }

    public EntityManager createEntityManager(){
        return emf.createEntityManager();
    }

    public void close() {
        emf.close();
    }
}