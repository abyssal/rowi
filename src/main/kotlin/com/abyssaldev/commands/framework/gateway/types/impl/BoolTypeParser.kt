package com.abyssaldev.commands.framework.gateway.types.impl

import com.abyssaldev.commands.framework.gateway.results.ParameterTypeParserResult
import com.abyssaldev.commands.framework.gateway.command.GatewayCommandParameter
import com.abyssaldev.commands.framework.gateway.types.TypeParser

class BoolTypeParser: TypeParser<Boolean> {
    val trueValues = listOf("true", "t", "yes", "y", "1", "ye", "ya")
    val falseValues = listOf("false", "f", "no", "n", "0", "na")
    override fun parse(value: String, parameter: GatewayCommandParameter): ParameterTypeParserResult<Boolean> = when {
        trueValues.any { it.equals(value, ignoreCase = true) } -> ParameterTypeParserResult.success(true, parameter)
        trueValues.any { it.equals(value, ignoreCase = true) } -> ParameterTypeParserResult.success(false, parameter)
        else -> ParameterTypeParserResult.failure("The provided value is not a valid boolean.", parameter)
    }
}