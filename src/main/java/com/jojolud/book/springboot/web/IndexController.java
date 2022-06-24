package com.jojolud.book.springboot.web;

import com.jojolud.book.springboot.config.auth.dto.SessionUser;
import com.jojolud.book.springboot.service.posts.PostsService;
import com.jojolud.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController { // 페이지에 관련된 컨트롤러는 모두 IndexController를 사용

    private final PostsService postsService;
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        /** Model
         * 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있음
         * postsService.findAllDesc()로 가져온 결과를 posts로 index.mustache에 전달
         */

        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        /** (SessionUser) httpSession.getAttribute("user");
         * 앞서 작성된 CustomerOAuth2UserService에서 로그인 성공 시 세션에 SessionUser를 저장하도록 구성
         * 즉, 로그인 성공 시 httpSession.getAttribute("user")에서 값을 가져올 수 있음
         */

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }
        /** if(user != null)
         * 세션에 저장된 값이 있을 때만 model에 userName으로 등록
         * 세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보이게 됨
         */

        return "index";
    }
    /**
     * 머스테치 스타터 덕분에 컨트롤러에서 문자열을 반환할 때 앞의 경로와 뒤의 파일 확장자는 자동으로 지정됨
     * 앞의 경로 : src/main/resource/templates
     * 뒤의 파일 확장자 : .mustache
     *      즉, 여기선 index를 반환하므로 src/main/resource/templates/index.mustache로 전환되어 View Resolver가 처리하게 됨
     *          *View Resolver : URL 요청의 결과를 전달할 타입과 값을 지정하는 관리자
     */

    @GetMapping("/posts/save")
    public String postsSave() { // /posts/save를 호출하면 posts-save.mustache를 호출하는 메소드
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
