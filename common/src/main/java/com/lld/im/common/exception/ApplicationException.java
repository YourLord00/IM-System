package com.lld.im.common.exception;

@Slf4j
@RestController
public class MyErrorController extends BasicErrorController {

    public MyErrorController() {
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    /**
     * produces 设置返回的数据类型：application/json
     * @param request 请求
     * @return 自定义的返回实体类
     */
    @Override
    @RequestMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        // 获取错误信息
        Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = getStatus(request);
        String code = body.get("status").toString();
        String message = body.get("message").toString();
        return new ResponseEntity(ApiUtil.fail(message), HttpStatus.OK);
    }
}
