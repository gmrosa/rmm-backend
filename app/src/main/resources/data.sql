-- DEVICE_TYPE --------------------------------------------------------------------------------------------------------
INSERT INTO device_type(id, name) VALUES(random_uuid(), 'Windows');
INSERT INTO device_type(id, name) VALUES(random_uuid(), 'Mac');
-- DEVICE -------------------------------------------------------------------------------------------------------------
INSERT INTO device(id,name,device_type_id) VALUES(random_uuid(), 'Windows Workstation', (SELECT id FROM device_type WHERE name LIKE 'Windows'));
INSERT INTO device(id,name,device_type_id) VALUES(random_uuid(), 'Windows Server', (SELECT id FROM device_type WHERE name LIKE 'Windows'));
INSERT INTO device(id,name,device_type_id) VALUES(random_uuid(), 'Mac Server', (SELECT id FROM device_type WHERE name LIKE 'Mac'));
-- CUSTOMER -----------------------------------------------------------------------------------------------------------
INSERT INTO customer(id, name) VALUES(random_uuid(), 'TBLU Technology');
INSERT INTO customer(id, name) VALUES(random_uuid(), 'Honda');
INSERT INTO customer(id, name) VALUES(random_uuid(), 'USC');
INSERT INTO customer(id, name) VALUES(random_uuid(), 'Maisons du Monde');
-- DEVICE_USAGE -------------------------------------------------------------------------------------------------------
INSERT INTO device_usage(id, customer_id, device_id, quantity)
    VALUES(random_uuid(), (SELECT id FROM customer WHERE name LIKE 'TBLU Technology'), (SELECT id FROM device WHERE name LIKE 'Windows Workstation'), 2);
INSERT INTO device_usage(id, customer_id, device_id, quantity)
    VALUES(random_uuid(), (SELECT id FROM customer WHERE name LIKE 'TBLU Technology'), (SELECT id FROM device WHERE name LIKE 'Mac Server'), 3);
-- SERVICE_TYPE -------------------------------------------------------------------------------------------------------
INSERT INTO service_type(id, name) VALUES(random_uuid(), 'Device');
INSERT INTO service_type(id, name) VALUES(random_uuid(), 'Antivirus');
INSERT INTO service_type(id, name) VALUES(random_uuid(), 'Backup');
INSERT INTO service_type(id, name) VALUES(random_uuid(), 'PSA');
INSERT INTO service_type(id, name) VALUES(random_uuid(), 'Screen Share');
-- SERVICE ------------------------------------------------------------------------------------------------------------
INSERT INTO service(id, service_type_id, price) VALUES(random_uuid(), (SELECT id FROM service_type WHERE name LIKE 'Device'), 4.00);
INSERT INTO service(id, service_type_id, device_type_id, price)
    VALUES(random_uuid(), (SELECT id FROM service_type WHERE name LIKE 'Antivirus'), (SELECT id FROM device_type WHERE name LIKE 'Windows'), 5.00);
INSERT INTO service(id, service_type_id, device_type_id, price)
    VALUES(random_uuid(), (SELECT id FROM service_type WHERE name LIKE 'Antivirus'), (SELECT id FROM device_type WHERE name LIKE 'Mac'), 7.00);
INSERT INTO service(id, service_type_id, price) VALUES(random_uuid(), (SELECT id FROM service_type WHERE name LIKE 'Backup'), 3.00);
INSERT INTO service(id, service_type_id, price) VALUES(random_uuid(), (SELECT id FROM service_type WHERE name LIKE 'PSA'), 2.00);
INSERT INTO service(id, service_type_id, price) VALUES(random_uuid(), (SELECT id FROM service_type WHERE name LIKE 'Screen Share'), 1.00);
-- SERVICE_USAGE ------------------------------------------------------------------------------------------------------
INSERT INTO service_usage(id, device_usage_id, service_id)
    VALUES(random_uuid(),
           (SELECT id FROM device_usage WHERE customer_id = (SELECT id FROM customer WHERE name LIKE 'TBLU Technology')
                                          AND device_id   = (SELECT id FROM device WHERE name LIKE 'Windows Workstation')),
           (SELECT id from service WHERE service_type_id  = (SELECT id FROM service_type WHERE name LIKE 'Device') AND device_type_id IS NULL)
    );
INSERT INTO service_usage(id, device_usage_id, service_id)
    VALUES(random_uuid(),
           (SELECT id FROM device_usage WHERE customer_id = (SELECT id FROM customer WHERE name LIKE 'TBLU Technology')
                                          AND device_id   = (SELECT id FROM device WHERE name LIKE 'Windows Workstation')),
           (SELECT id from service WHERE service_type_id  = (SELECT id FROM service_type WHERE name LIKE 'Antivirus')
                                     AND device_type_id   = (SELECT id FROM device_type WHERE name LIKE 'Windows'))
    );
INSERT INTO service_usage(id, device_usage_id, service_id)
    VALUES(random_uuid(),
           (SELECT id FROM device_usage WHERE customer_id = (SELECT id FROM customer WHERE name LIKE 'TBLU Technology')
                                          AND device_id   = (SELECT id FROM device WHERE name LIKE 'Windows Workstation')),
           (SELECT id from service WHERE service_type_id  = (SELECT id FROM service_type WHERE name LIKE 'Backup') AND device_type_id IS NULL)
    );
INSERT INTO service_usage(id, device_usage_id, service_id)
    VALUES(random_uuid(),
           (SELECT id FROM device_usage WHERE customer_id = (SELECT id FROM customer WHERE name LIKE 'TBLU Technology')
                                          AND device_id   = (SELECT id FROM device WHERE name LIKE 'Windows Workstation')),
           (SELECT id from service WHERE service_type_id  = (SELECT id FROM service_type WHERE name LIKE 'Screen Share') AND device_type_id IS NULL)
    );
INSERT INTO service_usage(id, device_usage_id, service_id)
    VALUES(random_uuid(),
           (SELECT id FROM device_usage WHERE customer_id = (SELECT id FROM customer WHERE name LIKE 'TBLU Technology')
                                          AND device_id   = (SELECT id FROM device WHERE name LIKE 'Mac Server')),
           (SELECT id from service WHERE service_type_id  = (SELECT id FROM service_type WHERE name LIKE 'Device') AND device_type_id IS NULL)
    );
INSERT INTO service_usage(id, device_usage_id, service_id)
    VALUES(random_uuid(),
           (SELECT id FROM device_usage WHERE customer_id = (SELECT id FROM customer WHERE name LIKE 'TBLU Technology')
                                          AND device_id   = (SELECT id FROM device WHERE name LIKE 'Mac Server')),
           (SELECT id from service WHERE service_type_id  = (SELECT id FROM service_type WHERE name LIKE 'Antivirus')
                                     AND device_type_id   = (SELECT id FROM device_type WHERE name LIKE 'Mac'))
    );
INSERT INTO service_usage(id, device_usage_id, service_id)
    VALUES(random_uuid(),
           (SELECT id FROM device_usage WHERE customer_id = (SELECT id FROM customer WHERE name LIKE 'TBLU Technology')
                                          AND device_id   = (SELECT id FROM device WHERE name LIKE 'Mac Server')),
           (SELECT id from service WHERE service_type_id  = (SELECT id FROM service_type WHERE name LIKE 'Backup') AND device_type_id IS NULL)
    );
INSERT INTO service_usage(id, device_usage_id, service_id)
    VALUES(random_uuid(),
           (SELECT id FROM device_usage WHERE customer_id = (SELECT id FROM customer WHERE name LIKE 'TBLU Technology')
                                          AND device_id   = (SELECT id FROM device WHERE name LIKE 'Mac Server')),
           (SELECT id from service WHERE service_type_id  = (SELECT id FROM service_type WHERE name LIKE 'Screen Share') AND device_type_id IS NULL)
    );