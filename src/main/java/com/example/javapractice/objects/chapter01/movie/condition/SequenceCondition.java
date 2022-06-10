package com.example.javapractice.objects.chapter01.movie.condition;

import com.example.javapractice.objects.chapter01.movie.domain.Screening;

public class SequenceCondition implements DiscountCondition {

    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }

}
