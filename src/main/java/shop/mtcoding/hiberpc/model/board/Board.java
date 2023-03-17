package shop.mtcoding.hiberpc.model.board;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.mtcoding.hiberpc.model.user.User;

@Getter
@Setter
@Entity
@Table(name = "board_tb")
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne // 앞이 현 테이블 뒤가 밑의 내용
    private User user;
    private String title;
    private String content;
    @CreationTimestamp
    private Timestamp createdAt;

}
