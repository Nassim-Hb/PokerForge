package com.nasshb.pokerforge;

import com.nasshb.pokerforge.pokeruser.dto.PokerUserResponse;
import com.nasshb.pokerforge.pokeruser.entity.PokerUser;
import com.nasshb.pokerforge.pokeruser.repository.PokerUserRepository;
import com.nasshb.pokerforge.pokeruser.service.PokerUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PokerUserTest {

    @Mock
    private PokerUserRepository userRepository;

    @InjectMocks
    private PokerUserService userService;

    @Test
    void userCreatedSuccessfully(){
        PokerUser user = new PokerUser(
                "Nassim",
                "Hb",
                "azerty",
                "nassimhb@gmail.com"
        );
        user.setId(1L);
        when(userRepository.save(any(PokerUser.class)))
                .thenReturn(user);

        //ACT
        PokerUserResponse userCreated = userService.createUser("Nassim", "Hb", "azerty", "nassimhb@gmail.com");

        //ASSERT
        assertThat(userCreated.getFirstName()).isEqualTo("Nassim");
        assertThat(userCreated.getLastName()).isEqualTo("Hb");
        assertThat(userCreated.getEmail()).isEqualTo("nassimhb@gmail.com");
        verify(userRepository).save(any(PokerUser.class));
    }
}
