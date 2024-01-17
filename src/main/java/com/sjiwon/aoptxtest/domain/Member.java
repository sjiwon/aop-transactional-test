package com.sjiwon.aoptxtest.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Getter
@NoArgsConstructor(access = PROTECTED)
@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String name;

    public Member(final String name) {
        this.name = name;
    }

    public void update(final String name) {
        this.name = name;
    }
}
