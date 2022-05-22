package zjt.learn.service;

/**
 * 功能：
 */
public interface IdGenerateService {
    /**
     * 雪花算法
     * @return
     */
    Long generate();


    Long generateV2(Long param);

}
