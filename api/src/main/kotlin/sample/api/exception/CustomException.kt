package sample.api.exception

class CustomException(val customErrorCode: CustomErrorCode) : RuntimeException()