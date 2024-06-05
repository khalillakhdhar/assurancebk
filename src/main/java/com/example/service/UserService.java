package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.entity.User;
import com.example.entity.Demande;
import com.example.entity.Convention;
import com.example.entity.Facture;
import com.example.repository.UserRepository;
import com.example.repository.DemandeRepository;
import com.example.repository.ConventionRepository;
import com.example.repository.FactureRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private ConventionRepository conventionRepository;

    @Autowired
    private FactureRepository factureRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);
        return user.map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public User getOneUser(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    public User addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return userRepository.findByEmail(currentUserName).orElse(null);
    }

    public Demande addDemande(Demande demande) {
        User currentUser = getCurrentUser();
        demande.setUser(currentUser);
        return demandeRepository.save(demande);
    }

    public Convention addConvention(Convention convention) {
        User currentUser = getCurrentUser();
        convention.setUser(currentUser);
        return conventionRepository.save(convention);
    }

    public Facture addFacture(Facture facture) {
        User currentUser = getCurrentUser();
        facture.setUser(currentUser);
        return factureRepository.save(facture);
    }
}
