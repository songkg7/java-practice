package chainofresponsibility.filterchain;

public class LastFilter implements FilterChain {

    @Override
    public void setNext(FilterChain nextFilter) {

    }

    @Override
    public FilterChain doFilter(SignUpForm signUpForm) {
        return null;
    }

}
