package chainofresponsibility.filterchain;

public class PasswordValidationFilter implements FilterChain {

    private FilterChain nextFilter;

    @Override
    public void setNext(FilterChain nextFilter) {
        this.nextFilter = nextFilter;
    }

    @Override
    public FilterChain doFilter(SignUpForm signUpForm) {
        if (!signUpForm.getPassword().matches("\\d")) {
            System.out.println("비밀번호는 숫자여야 합니다.");
        }

        return null;
    }

}
