package org.algosketch.corespring.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
