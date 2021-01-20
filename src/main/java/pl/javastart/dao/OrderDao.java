package pl.javastart.dao;

import org.springframework.stereotype.Repository;
import pl.javastart.model.Order;

import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderDao extends GenericDao<Order, Long> {
}
