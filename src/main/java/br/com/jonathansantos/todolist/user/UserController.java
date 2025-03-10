package br.com.jonathansantos.todolist.user;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * Modificador
 * public
 * private
 * protected
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    /**
     *  String (texto)
     *  Interger (int) números inteiros
     *  Double (double) Números 0.0000  
     *  Float (float) Números 0.000
     *  char (A C)
     *  Date (data)
     *  void
     */
    /*
     * Body
     */
    @PostMapping("/")
     public ResponseEntity create(@RequestBody UserModel userModel) {System.out.println(userModel.getUsername());
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null) {
            // Mensagem de erro
            // Status code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
        }

        var passwordHashred = BCrypt.withDefaults()
        .hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userCreated);

    }
}
