package com.ohgiraffers.post_st.controller;


import com.ohgiraffers.post_st.model.dto.HjBlogDTO;
import com.ohgiraffers.post_st.service.HjService;

@Controller
@RequestMapping("/hj")
public class HjController
{
    private final HjService hjService;

    @Autowired
    public HjControllerController(HjService hjService)
    {
        this.hjService = hjService;

    }
    @GetMapping("main")
    public String mainpae()
    {
        return "hj/main";
    }
    @GetMapping("/post")
    public String showPostForm() { return "hj/post"; }

    public ModelAndview postBlog(HjBlogDTO hjBlogDTO,ModelAndView mv)
    {
        if(hjBlogDTO.gtBlogTitle() == null || hjBlogDTO.getBlogTitle().equals(""))
        {
            mv.setViewName("redirect:/jun/post");
        }
        if(junBlogDTO.getBlogContent() == null || hjBlogDTO.getBlogContent().equals(""))
        {
            mv.setviewName("redirect:/hj/post");
        }
        int result = hjService.post(hjBlogDTO);
        if(result <= 0){
            mv.setViewName("error/page");
        }else
        {
            mv.setViewName("hj/post");
        }
        return mv;
    }
    @GetMapping("/post-list")
    public String getBlogList(Model model)
    {

        List<HjBlog> blogList = hjService.getAllBlogs();
        model.addAttribute("blogList",blogList);
        return "/hj/post-list";
        @GetMapping("/post-detail/{blogid}")
        public String getblogDetail(@PathVariable Long blogid,Model model)
        {
            Hjblog blog = hjService.getBlogById(blogid);
            model.addAttribute("blog",blog);
            return "/jun/post-detail";
        }
        @GetMapping("/post-edit")
        public String showUpdateForm(@RequestParam("id") Long id, Model model)
        {
            JunBlog blog = junService.getBlogById(id);
            JunBlogDTO blogDTO = new HjBlogDTO();
            blogDTO.setId(blog.getId());
            blogDTO.setBlogTitle(blog.getBlogTitle());
            blogDTO.setBlogContent(blog.getBlogContent());
            model.addAttribute("junBlogDTO",blogDTO);
            return "/jun/post-edit";
        }

        @PostMapping("update")
        public String updatePost(@ModelAttribute("hjBlogDTO") HjblogDTO hjBlogDTO)
        {
            HjBlog updatedPost = hjService.updatePost(junBlogDTO);
            return "redirect:/hj/post-detail/" + updatedPost.getId();
        }
        @postMapping("/delete/{id}")
        public String deleteBlog(@PathVariable id)
            {
                    junService.deleteBlog(id);
        return "redirect:/hj/post-list";
                    }

    }




