package com.sportconnect.teamsservice.command.interceptors;

import com.sportconnect.teamsservice.command.commands.CreateTeamCommand;
import com.sportconnect.teamsservice.core.data.TeamLookUpEntity;
import com.sportconnect.teamsservice.core.data.TeamsLookUpRepository;
import org.axonframework.commandhandling.CommandMessage;
import org.axonframework.messaging.MessageDispatchInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.BiFunction;

@Component
public class CreateTeamCommandInterceptor implements MessageDispatchInterceptor<CommandMessage<?>> {
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateTeamCommandInterceptor.class);

    private final TeamsLookUpRepository teamsLookUpRepository;

    public CreateTeamCommandInterceptor(TeamsLookUpRepository teamsLookUpRepository) {
        this.teamsLookUpRepository = teamsLookUpRepository;
    }

    @Override
    public BiFunction<Integer, CommandMessage<?>, CommandMessage<?>> handle(List<? extends CommandMessage<?>> messages) {
        return (index, command) -> {

            LOGGER.info("[CreateProductCommandInterceptor] ->  Intercepted command called: " + command.getPayloadType());

            if (CreateTeamCommand.class.equals(command.getPayloadType())) {
                CreateTeamCommand createTeamCommand = (CreateTeamCommand) command.getPayload();

                TeamLookUpEntity teamLookUpEntity = teamsLookUpRepository.findByTeamIdOrUserIdOrTeamName(createTeamCommand.getTeamId(), createTeamCommand.getUserId(), createTeamCommand.getTeamName());
                if (teamLookUpEntity != null) {
                    throw new IllegalStateException((String.format("Team with %s is already existed",createTeamCommand.getTeamName())));
                }
            }
        return command;
        };
    }
}
