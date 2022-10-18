package com.ninjaone.rmmbackend.app.service;

import com.ninjaone.rmmbackend.model.dto.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles(profiles = "empty-database")
public class CustomerServiceTest {

    @Autowired
    private DeviceTypeService deviceTypeService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private DeviceUsageService deviceUsageService;
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private ServiceService serviceService;
    @Autowired
    private ServiceUsageService serviceUsageService;

    @Test
    public void shouldReturnMonthlyCost() {
        DeviceTypeDTO windows = deviceTypeService.add(DeviceTypeDTO.builder().name("Windows").build());
        DeviceTypeDTO mac = deviceTypeService.add(DeviceTypeDTO.builder().name("Mac").build());
        DeviceDTO windowsWorkstation = deviceService.add(DeviceDTO.builder().name("Windows Workstation").deviceType(windows.getName()).build());
        DeviceDTO macServer = deviceService.add(DeviceDTO.builder().name("Mac Server").deviceType(mac.getName()).build());
        CustomerDTO customer = customerService.add(CustomerDTO.builder().name("Hire me I'm awesome").build());
        DeviceUsageDTO windowsUsage = deviceUsageService.add(DeviceUsageDTO.builder()
                .customerName(customer.getName()).deviceName(windowsWorkstation.getName()).quantity(2)
                .build());
        DeviceUsageDTO macUsage = deviceUsageService.add(DeviceUsageDTO.builder()
                .customerName(customer.getName()).deviceName(macServer.getName()).quantity(3)
                .build());
        ServiceTypeDTO device = serviceTypeService.add(ServiceTypeDTO.builder().name("Device").build());
        ServiceTypeDTO antivirus = serviceTypeService.add(ServiceTypeDTO.builder().name("Antivirus").build());
        ServiceTypeDTO backup = serviceTypeService.add(ServiceTypeDTO.builder().name("Backup").build());
        ServiceTypeDTO screenShare = serviceTypeService.add(ServiceTypeDTO.builder().name("Screen Share").build());
        ServiceDTO deviceService = serviceService.add(ServiceDTO.builder().serviceTypeName(device.getName()).price(4F).build());
        ServiceDTO antivirusWindowsService = serviceService.add(ServiceDTO.builder()
                .serviceTypeName(antivirus.getName()).deviceTypeName(windows.getName()).price(5F)
                .build());
        ServiceDTO antivirusMacService = serviceService.add(ServiceDTO.builder()
                .serviceTypeName(antivirus.getName()).deviceTypeName(mac.getName()).price(7F)
                .build());
        ServiceDTO backupService = serviceService.add(ServiceDTO.builder().serviceTypeName(backup.getName()).price(3F).build());
        ServiceDTO screenShareService = serviceService.add(ServiceDTO.builder().serviceTypeName(screenShare.getName()).price(1F).build());
        serviceUsageService.add(ServiceUsageDTO.builder().deviceUsageId(windowsUsage.getId()).serviceId(deviceService.getId()).build());
        serviceUsageService.add(ServiceUsageDTO.builder().deviceUsageId(windowsUsage.getId()).serviceId(antivirusWindowsService.getId()).build());
        serviceUsageService.add(ServiceUsageDTO.builder().deviceUsageId(windowsUsage.getId()).serviceId(backupService.getId()).build());
        serviceUsageService.add(ServiceUsageDTO.builder().deviceUsageId(windowsUsage.getId()).serviceId(screenShareService.getId()).build());
        serviceUsageService.add(ServiceUsageDTO.builder().deviceUsageId(macUsage.getId()).serviceId(deviceService.getId()).build());
        serviceUsageService.add(ServiceUsageDTO.builder().deviceUsageId(macUsage.getId()).serviceId(antivirusMacService.getId()).build());
        serviceUsageService.add(ServiceUsageDTO.builder().deviceUsageId(macUsage.getId()).serviceId(backupService.getId()).build());
        serviceUsageService.add(ServiceUsageDTO.builder().deviceUsageId(macUsage.getId()).serviceId(screenShareService.getId()).build());

        Assertions.assertThat(customerService.getMonthlyCostById(customer.getId())).isEqualTo(71F);
    }

}
