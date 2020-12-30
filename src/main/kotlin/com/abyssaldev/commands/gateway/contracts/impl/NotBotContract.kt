package com.abyssaldev.commands.gateway.contracts.impl

import com.abyssaldev.commands.gateway.GatewayCommandRequest
import com.abyssaldev.commands.gateway.common.SuppliedArgument
import com.abyssaldev.commands.gateway.contracts.ArgumentContract
import com.abyssaldev.commands.gateway.contracts.ArgumentContractable
import net.dv8tion.jda.api.entities.Member

class NotBotContract: ArgumentContractable<Member> {
    override fun evaluateContract(
        argument: SuppliedArgument<Member>,
        request: GatewayCommandRequest
    ): ArgumentContract.Result<Member> {
        return if (argument.value.id == request.botUser.id) {
            ArgumentContract.Result.failure("`${argument.name}` cannot be me.", argument, this)
        } else {
            ArgumentContract.Result.success(argument, this)
        }
    }
}