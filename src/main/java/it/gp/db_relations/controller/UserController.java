package it.gp.db_relations.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.gp.db_relations.exception.ResourceNotFoundException;
import it.gp.db_relations.model.dto.UserDTO;
import it.gp.db_relations.model.entity.User;
import it.gp.db_relations.repository.UserRepository;
import it.gp.db_relations.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Gestione Utenti", description = "Api di gestione utenti")
public class UserController {

    private final IUserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Recupera utenti", description = "Torna la lista di tutti gli utenti sul database")
    @ApiResponse(responseCode = "200", description = "Utenti recuperati con successo")
    public List<UserDTO> getAllUsers() {
        logger.debug("Una stringa di DEBUG");
        logger.info("Chiamata effettuata al metodo getAllUsers()");
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Recupera utente per id", description = "Questo endpoint torna l'utente che ha id passato in ingresso, se presente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Utente trovato"),
            @ApiResponse(responseCode = "404", description = "Utente non trovato con l'id specificato")
    })
    public ResponseEntity<UserDTO> getUserById(
            @Parameter(name = "id", required = true, description = "Identificativo dell'utente, corrisponde alla primary key del database")
            @PathVariable Long id) {
        UserDTO user = userService.getUserById(id);
        if (user == null) {
            logger.error("Utente non trovato con id: " + id);
            // TODO SCRIVERE I VARI THROW NEI CONTROLLER / SERVICE
            throw new ResourceNotFoundException("User with id " + id + " not found.");
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }
}