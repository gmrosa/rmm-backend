package com.ninjaone.rmmbackend.app.repository;

import com.ninjaone.rmmbackend.model.entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends NameRepository<CustomerEntity> {

    @Query(value = """
                select sum(cost) cost from
                (select grp.name, sum(grp.cost) cost from (
                    select st.name, (s.price * dug.quantity) as cost from
                    service s,
                    service_type st,
                    service_usage su,
                    (SELECT du.id, du.quantity FROM device_usage du WHERE du.customer_id = (SELECT c.id FROM customer c WHERE c.id = :customerId)) dug
                    where su.device_usage_id = dug.id
                    and su.service_id = s.id
                    and s.service_type_id = st.id) grp
                group by name)    
            """, nativeQuery = true)
    Float getMonthlyCostById(String customerId);

}