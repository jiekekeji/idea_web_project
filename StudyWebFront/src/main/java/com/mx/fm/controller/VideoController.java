package com.mx.fm.controller;

import com.mx.fm.constant.PathConstant;
import com.mx.fm.model.Video;
import com.mx.fm.model.VideoClazz;
import com.mx.fm.service.UserService;
import com.mx.fm.service.VideoService;
import com.mx.fm.utils.TextUtils;
import com.mx.fm.utils.TimeUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016-07-18.
 */
@Controller
@RequestMapping(value = "/video")
public class VideoController {

    private static Logger logger = Logger.getLogger(VideoController.class);
    private VideoService service = new VideoService();

    /**
     * 查询视频分类信息及该分类下的视频总数
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/findVideoClazz", method = RequestMethod.GET)
    @ResponseBody
    public Map findVideoClazz(int page, int rows) {
        logger.debug("findVideoClazz:" + "page=" + page + " rows=" + rows);
        Map map = service.findVideoClazz(page, rows);
        logger.debug("findVideoClazz:" + map);
        return map;
    }

    /**
     * 根据分类名称查询视频分类信息及该分类下的视频总数
     *
     * @param name
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/findVideoClazzByName", method = RequestMethod.GET)
    @ResponseBody
    public Map findVideoClazzByName(String name, int page, int rows) {
        logger.debug("findVideoClazzByName:" + "name=" + name + " page=" + page + " rows=" + rows);
        Map map = service.findVideoClazzByName(name, page, rows);
        logger.debug("findVideoClazzByName:" + map);
        return map;
    }

    /**
     * 更新视频
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateVideoByID", method = RequestMethod.POST)
    @ResponseBody
    public Map updateVideoByID(HttpServletRequest request) {
        logger.debug("updateVideoByID:" + request);
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String source = request.getParameter("source");
        String duration = request.getParameter("duration");

        String language = request.getParameter("language");
        String status = request.getParameter("status");
        String istop = request.getParameter("istop");

        String videourl = request.getParameter("videourl");
        String classid = request.getParameter("classid");
        String outlineImgUrl = request.getParameter("outlineImgUrl");

        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(source)
                || TextUtils.isEmpty(duration) || TextUtils.isEmpty(language)
                || TextUtils.isEmpty(status)
                || TextUtils.isEmpty(videourl) || TextUtils.isEmpty(classid)
                || TextUtils.isEmpty(id)) {
            Map map = new HashMap();
            map.put("code", 4000);
            map.put("desc", "参数不正确");
            logger.debug("updateVideoByID:" + map);
            return map;
        }

        Video video = new Video();
        video.setId(Long.valueOf(id));
        video.setTitle(title);
        video.setContent(content);
        video.setSource(source);
        video.setDuration(duration);

        video.setUploadtime(TimeUtils.getDateTime(System.currentTimeMillis()));
        video.setLanguage(language);
        video.setStatus(Integer.valueOf(status));
        video.setIstop(Long.valueOf(istop));
        video.setVideourl(videourl);
        video.setClassid(Integer.valueOf(classid));
        video.setOutlineImgUrl(outlineImgUrl);//存文件的名称

        Map map = service.updateVideoByID(video);
        logger.debug("updateVideoByID:" + map);
        return map;
    }

    /**
     * 查找分页视频
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/findVideos", method = RequestMethod.GET)
    @ResponseBody
    public Map findVideos(int page, int rows) {
        logger.debug("findVideos:" + "page=" + page + " rows=" + rows);
        Map map = service.findVideos(page, rows);
        logger.debug("findVideos:" + map);
        return map;
    }

    /**
     * 查找分类下的分页视频
     *
     * @param classid
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/findVideosByClassID", method = RequestMethod.GET)
    @ResponseBody
    public Map findVideosByClassID(int classid, int page, int rows) {
        logger.debug("findVideosByClassID:" + "classid=" + classid + " page=" + page + " rows=" + rows);
        Map map = service.findVideosByClassID(classid, page, rows);
        logger.debug("findVideosByClassID:" + map);
        return map;
    }

    @RequestMapping(value = "/findVideosByID", method = RequestMethod.GET)
    @ResponseBody
    public Map findVideosByID(long id) {
        logger.debug("findVideosByID:" + "id=" + id);
        Map map = service.findVideosByID(id);
        logger.debug("findVideosByID:" + map);
        return map;
    }

    /**
     * 添加视频
     *
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/addNetVideo", method = RequestMethod.POST)
    @ResponseBody
    public Map addNetVideo(@RequestParam("image") MultipartFile file, HttpServletRequest request) {
        logger.debug("addNetVideo:" + file);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String source = request.getParameter("source");
        String duration = request.getParameter("duration");

        String language = request.getParameter("language");
        String status = request.getParameter("status");
        String istop = request.getParameter("istop");

        String videourl = request.getParameter("videourl");
        String classid = request.getParameter("classid");

        if (TextUtils.isEmpty(title) || TextUtils.isEmpty(source)
                || TextUtils.isEmpty(duration) || TextUtils.isEmpty(language)
                || TextUtils.isEmpty(status) || null == file
                || TextUtils.isEmpty(videourl) || TextUtils.isEmpty(classid)) {
            Map map = new HashMap();
            map.put("code", 4000);
            map.put("desc", "参数不正确");
            logger.debug("addNetVideo:" + map);
            return map;
        }

        //获取文件的后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = System.currentTimeMillis() + suffix;
        try {
            String filePath = PathConstant.UPLOAD_IMAGES + File.separator + fileName;
            FileCopyUtils.copy(IOUtils.toByteArray(file.getInputStream()), new File(filePath));
            Video video = new Video();
            video.setTitle(title);
            video.setContent(content);
            video.setSource(source);
            video.setDuration(duration);

            video.setUploadtime(TimeUtils.getDateTime(System.currentTimeMillis()));
            video.setLanguage(language);
            video.setStatus(Integer.valueOf(status));
            video.setIstop(Long.valueOf(istop));
            video.setVideourl(videourl);
            video.setClassid(Integer.valueOf(classid));
            video.setOutlineImgUrl(fileName);//存文件的名称

            Map map = service.addVideo(video);
            logger.debug("addNetVideo:" + map);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            Map map = new HashMap();
            map.put("code", 4000);
            map.put("desc", "异常了" + e.getMessage());
            logger.debug("addNetVideo:" + map);
        } finally {
            //不用关流，貌似里面自己关了
        }
        return null;
    }

    /**
     * 更新视频图片
     *
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value = "/updateImgByID", method = RequestMethod.POST)
    @ResponseBody
    public Map updateImgByID(@RequestParam("image") MultipartFile file, HttpServletRequest request) {
        logger.debug("updateImgByID:" + file);
        String id = request.getParameter("id");
        if (TextUtils.isEmpty(id) || null == file) {
            Map map = new HashMap();
            map.put("code", 4000);
            map.put("desc", "参数不正确");
            logger.debug("updateImgByID:" + map);
            return map;
        }

        //获取文件的后缀
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String fileName = System.currentTimeMillis() + suffix;
        try {
            String filePath = PathConstant.UPLOAD_IMAGES + File.separator + fileName;
            FileCopyUtils.copy(IOUtils.toByteArray(file.getInputStream()), new File(filePath));
            Map map = service.updateImgByID(Long.valueOf(id), fileName);
            logger.debug("updateImgByID:" + map);
            return map;
        } catch (IOException e) {
            e.printStackTrace();
            Map map = new HashMap();
            map.put("code", 4000);
            map.put("desc", "异常了" + e.getMessage());
            logger.debug("updateImgByID:" + map);
        } finally {
            //不用关流，貌似里面自己关了
        }
        return null;
    }

    /**
     * 根据ID删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteVideoByVideoid", method = RequestMethod.GET)
    @ResponseBody
    public Map deleteVideoByVideoid(long id) {
        logger.debug("deleteVideoByVideoid:" + "id=" + id);
        Map map = service.deleteVideoByVideoid(id);
        logger.debug("deleteVideoByVideoid:" + map);
        return map;
    }

    /**
     * 查找推荐置顶视频
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/findVideosByIsTop", method = RequestMethod.GET)
    @ResponseBody
    public Map findVideosByIsTop(int page, int rows) {
        logger.debug("findVideosByIsTop:" + "page=" + page + " rows=" + rows);
        Map map = service.findVideosByIsTop(page, rows);
        logger.debug("findVideosByIsTop:" + map);
        return map;
    }

    /**
     * 查找审核中的视频
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "/findVideosByStatus", method = RequestMethod.GET)
    @ResponseBody
    public Map findVideosByStatus(int page, int rows) {
        logger.debug("findVideosByStatus:" + "page=" + page + " rows=" + rows);
        Map map = service.findVideosByStatus(page, rows);
        logger.debug("findVideosByStatus:" + map);
        return map;
    }

}
