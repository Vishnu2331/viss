package com.hcl.airport_management_system_server.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.airport_management_system_server.AirportManagementSystemServerApplication;
import com.hcl.airport_management_system_server.model.Admin;
import com.hcl.airport_management_system_server.model.Aeroplane;
import com.hcl.airport_management_system_server.model.Hanger;
import com.hcl.airport_management_system_server.model.Manager;
import com.hcl.airport_management_system_server.model.Pilot;
import com.hcl.airport_management_system_server.service.AeroplaneService;
import com.hcl.airport_management_system_server.service.AirportAdminService;
import com.hcl.airport_management_system_server.service.AirportManagerService;
import com.hcl.airport_management_system_server.service.HangerService;
import com.hcl.airport_management_system_server.service.PilotService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/airport") 
public class AirportController {
	@Autowired
	AirportAdminService airportAdminService; 

	@Autowired
	AirportManagerService airportManagerService;

	@Autowired
	AeroplaneService aeroplaneService;

	@Autowired
	HangerService hangerService;

	@Autowired
	PilotService pilotService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AirportManagementSystemServerApplication.class);

	@PostMapping(value = "/admin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) {
		try {
			System.out.println(admin.getAdminPassword());
            LOGGER.info("Admin Created");
			Admin admin2 = airportAdminService.addAdminService(new Admin(admin.getAdminEmail(),
					admin.getAdminFirstName(), admin.getAdminLastName(), admin.getAdminAge(), admin.getAdminGender(),
					admin.getAdminContactNumber(), admin.getAdminPassword()));
			return new ResponseEntity<>(admin2, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/admin")
	public ResponseEntity<List<Admin>> getAllAdmins() {
		List<Admin> admins;
		try {
			admins = (List<Admin>) airportAdminService.findAll();
         LOGGER.info("Getting admins from Databse successfull");
			if (admins.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(admins, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/admin/{adminEmail}")
	public ResponseEntity<Admin> findByadminEmail(@PathVariable("adminEmail") String adminEmail) {
		try {
			Admin admin1 = airportAdminService.findByAdminEmail(adminEmail);
			return new ResponseEntity<>(admin1, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping(value = "/manager")
	public ResponseEntity<Manager> addManager(@RequestBody Manager manager) {
		try {
			 LOGGER.info("Manager Created Successfully");
			Manager Manager2 = airportManagerService.addManagerService(new Manager(manager.getManagerEmail(),
					manager.getManagerFirstName(), manager.getManagerLastName(), manager.getManagerAge(),
					manager.getManagerGender(), manager.getManagerContactNumber(), manager.getManagerPassword()));
			return new ResponseEntity<>(Manager2, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/manager")
	public ResponseEntity<List<Manager>> getAllManagers() {
		List<Manager> managers;
		try {
			managers = (List<Manager>) airportManagerService.findAll();
			 LOGGER.info("List of Managers Waiting for approval");
			if (managers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(managers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/manager/{managerEmail}")
	public ResponseEntity<Manager> findByManagerEmail(@PathVariable("managerEmail") String managerEmail) {
		try {
			Manager manager1 = airportManagerService.findByManagerEmail(managerEmail);
			 LOGGER.info("Getting ManagerBy email");
			return new ResponseEntity<>(manager1, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PutMapping(value = "/manager/update")
	public Manager updateCustomer(@RequestBody Manager manager) {
		 LOGGER.info("Updating manager status");
		Manager manager1 = airportManagerService.updateManagerStatus(
				new Manager(manager.getManagerId(), manager.getManagerEmail(), manager.getManagerFirstName(),
						manager.getManagerLastName(), manager.getManagerAge(), manager.getManagerGender(),
						manager.getManagerContactNumber(), manager.getManagerPassword(), manager.getManagerStatus()));
		return manager1;
	}

	@PostMapping(value = "/aeroplane")
	public ResponseEntity<Aeroplane> addAeroplane(@RequestBody Aeroplane aeroplane) {
		try {
			 LOGGER.info("Adding aeroplane to the airport");
			Aeroplane aeroplane2 = aeroplaneService.addAeroplaneService(new Aeroplane(aeroplane.getAeroplaneName(),
					aeroplane.getAeroplaneCompanyName(), "pending", "pending"));
			return new ResponseEntity<>(aeroplane2, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@PostMapping(value = "/hanger")
	public ResponseEntity<Hanger> addHanger(@RequestBody Hanger hanger) {
		try {
			LOGGER.info("Adding Hanger to the airport");
			Hanger hanger2 = hangerService.addHangerService(
					new Hanger(hanger.getHangerName(), hanger.getHangerCapacity(), hanger.getHangerCapacity()));
			return new ResponseEntity<>(hanger2, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/aeroplane/hanger")
	public ResponseEntity<List<Aeroplane>> getAllAeroplanes() {
		List<Aeroplane> aeroplanes;
		List<Aeroplane> aeroplanes1 = new ArrayList<Aeroplane>();
		try {
			aeroplanes = (List<Aeroplane>) aeroplaneService.findAll();
			LOGGER.info("getting aeroplanes which don't have an hanger");
			for (Aeroplane aeroplane : aeroplanes) {
				if (aeroplane.getHanger() == null) {

					aeroplanes1.add(aeroplane);
				}

			}

			if (aeroplanes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(aeroplanes1, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/hanger")
	public ResponseEntity<List<Hanger>> getAllHangers() {
		List<Hanger> hangers;
		List<Hanger> hangers2 = new ArrayList<Hanger>();

		try {
			LOGGER.info("Getting hangers which are available");
			hangers = (List<Hanger>) hangerService.findAll();
			for (Hanger hanger : hangers) {
				if (hanger.getHangerAvailability() > 0) {
					hangers2.add(hanger);
				}
			}

			if (hangers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(hangers2, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/aeroplane/{aeroplaneId}/{hangerId}")
	public ResponseEntity<Integer> getCustomerById(@PathVariable("aeroplaneId") long aeroplaneId,
			@PathVariable("hangerId") long hangerId) {
		int a = 0;
		System.out.println(aeroplaneId + " " + hangerId);
		LOGGER.info("Assigning hanger to aeroplane");
		a = aeroplaneService.updateHangerId(aeroplaneId, hangerId);

		if (a > 0) {
			return new ResponseEntity<>(a, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping(value = "/hanger/update")
	public Hanger updateHanger(@RequestBody Hanger hanger) {
		LOGGER.info("Updating hanger availability count");
		Hanger hanger1 = hangerService.updateHangerAvailability(new Hanger(hanger.getHangerId(), hanger.getHangerName(),
				hanger.getHangerCapacity(), hanger.getHangerAvailability()));
		return hanger1;
	}

	@PostMapping(value = "/pilot")
	public ResponseEntity<Pilot> addPilot(@RequestBody Pilot pilot) {
		try {
			LOGGER.info("Adding Pilot");
			Pilot pilot2 = pilotService.addPilotService(new Pilot(pilot.getPilotFirstName(), pilot.getPilotLastName(),
					pilot.getPilotAge(), pilot.getPilotGender(), pilot.getPilotContactNumber()));
			return new ResponseEntity<>(pilot2, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/pilot")
	public ResponseEntity<List<Pilot>> getAllPilots() {
		List<Pilot> pilots;
		List<Pilot> pilots2 = new ArrayList<Pilot>();

		try {
			LOGGER.info("List of all pilots who are free");
			pilots = (List<Pilot>) pilotService.findAll();
			for (Pilot pilot : pilots) {
				if (pilot.getAddress() == null) {
					pilots2.add(pilot);
				}
			}
			if (pilots2.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(pilots2, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/aeroplane/pilot/{aeroplaneId}/{pilotId}")
	public ResponseEntity<Integer> getAeroplaneById(@PathVariable("aeroplaneId") long aeroplaneId,
			@PathVariable("pilotId") long pilotId) {
		int a = 0;
		System.out.println(aeroplaneId + " " + pilotId);
		LOGGER.info("assigning pilot to aeroplane");
		a = aeroplaneService.updatePilotId(aeroplaneId, pilotId);

		if (a > 0) {
			return new ResponseEntity<>(a, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/aeroplane/pilot")
	public ResponseEntity<List<Aeroplane>> getAllAeroplanes1() {
		List<Aeroplane> aeroplanes;
		List<Aeroplane> aeroplanes1 = new ArrayList<Aeroplane>();
		try {
			aeroplanes = (List<Aeroplane>) aeroplaneService.findAll();
			LOGGER.info("list of aerpoplanes who don't have pilots");
			for (Aeroplane aeroplane : aeroplanes) {
				if (aeroplane.getPilot() == null) {

					aeroplanes1.add(aeroplane);
				}

			}

			if (aeroplanes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(aeroplanes1, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/pilot/aeroplane/{aeroplaneId}/{pilotId}")
	public ResponseEntity<Integer> getPilotById(@PathVariable("aeroplaneId") long aeroplaneId,
			@PathVariable("pilotId") long pilotId) {
		int a = 0;
		System.out.println(aeroplaneId + " " + pilotId);
		LOGGER.info("updating pilotId in Aeroplane");
		a = pilotService.updatePilotId(aeroplaneId, pilotId);

		if (a > 0) {
			return new ResponseEntity<>(a, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/aeroplane/hanger/approval")
	public ResponseEntity<List<Aeroplane>> getAllAeroplanes2() {
		List<Aeroplane> aeroplanes;
		List<Aeroplane> aeroplanes1 = new ArrayList<Aeroplane>();
		try {
			aeroplanes = (List<Aeroplane>) aeroplaneService.findAll();
			LOGGER.info("list of aeroplanes which are waiting for hanger approval");
			for (Aeroplane aeroplane : aeroplanes) {
				if (aeroplane.getHanger() != null) {
					aeroplanes1.add(aeroplane);
				}
			}
			if (aeroplanes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(aeroplanes1, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/aeroplane/pilot/approval1")
	public ResponseEntity<List<Aeroplane>> getAllAeroplanes3() {
		List<Aeroplane> aeroplanes;
		List<Aeroplane> aeroplanes1 = new ArrayList<Aeroplane>();
		try {
			aeroplanes = (List<Aeroplane>) aeroplaneService.findAll();
			LOGGER.info("list of aeroplanes which are waiting for pilot appoval");
			for (Aeroplane aeroplane : aeroplanes) {
				if (aeroplane.getPilot() != null) {
					aeroplanes1.add(aeroplane);
				}
			}
			if (aeroplanes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(aeroplanes1, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/hanger/update/status/{statusMessage}/{aeroplaneId}")
	public ResponseEntity<Integer> getUpdateHnagerStatus(@PathVariable("statusMessage") String statusMessage,
			@PathVariable("aeroplaneId") long aeroplaneId) {
		int a = 0;
		a = aeroplaneService.updateAeroplaneId(statusMessage, aeroplaneId);
		LOGGER.info("Updating status of hanger acceptance");
		if (a > 0) {
			return new ResponseEntity<>(a, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/pilot/update/status/{statusMessage}/{aeroplaneId}")
	public ResponseEntity<Integer> getUpdatePilotStatus(@PathVariable("statusMessage") String statusMessage,
			@PathVariable("aeroplaneId") long aeroplaneId) {
		int a = 0;
		LOGGER.info("updating status of pilot acceptance");
		a = aeroplaneService.updateAeroplaneId1(statusMessage, aeroplaneId);
		if (a > 0) {
			return new ResponseEntity<>(a, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/hanger/hangers")
	public ResponseEntity<List<Hanger>> getAllHangers1() {
		List<Hanger> hangers;
		List<Hanger> hangers2 = new ArrayList<Hanger>();

		try {

			LOGGER.info("List of all hangers");
			hangers = (List<Hanger>) hangerService.findAll();
			for (Hanger hanger : hangers) {

				hangers2.add(hanger);

			}

			if (hangers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(hangers2, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/pilot/pilots")
	public ResponseEntity<List<Pilot>> getAllPilots1() {
		List<Pilot> pilots;
		List<Pilot> pilots2 = new ArrayList<Pilot>();

		try {
			LOGGER.info("list of all pilots");
			pilots = (List<Pilot>) pilotService.findAll();
			for (Pilot pilot : pilots) {

				pilots2.add(pilot);

			}
			if (pilots2.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(pilots2, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/aeroplane")
	public ResponseEntity<List<Aeroplane>> getAllAeroplanes4() {
		List<Aeroplane> aeroplanes;
		List<Aeroplane> aeroplanes1 = new ArrayList<Aeroplane>();
		try {
			aeroplanes = (List<Aeroplane>) aeroplaneService.findAll();
			LOGGER.info("list of all aeroplanes");
			for (Aeroplane aeroplane : aeroplanes) {
				aeroplanes1.add(aeroplane);
 
			} 
			if (aeroplanes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(aeroplanes1, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
