package com.group.libraryapp.service

import com.group.libraryapp.domain.user.UserRepository
import com.group.libraryapp.domain.user.userloanhistory.UserLoanHistoryRepository
import com.group.libraryapp.service.user.UserService
import com.group.libraryapp.util.TxHelper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class TempTest @Autowired constructor(
    private val userService: UserService,
    private val userRepository: UserRepository,
//    private val userLoanHistoryRepository: UserLoanHistoryRepository,
//    private val txHelper: TxHelper,
) {

    @Transactional
    @Test
    fun `유저 1명과 책 2권ㅇ을 저장하고 대출한다`() {
        // when
        userService.saveUserAndLoanTwoBooks()

        // then
        val users = userRepository.findAll()
        assertThat(users).hasSize(1)

        // 방법 1 @Transactional 사용 -> 토비, 영한님의 추천 방식
        assertThat(users[0].userLoanHistories).hasSize(2)

        // 방법 2 userLoanHistoryRepository 를 가져와서 테스트
//        val histories = userLoanHistoryRepository.findAll()
//        assertThat(histories).hasSize(2)
//        assertThat(histories[0].user.id).isEqualTo(users[0].id)

        // 방법 3 fetch join 으로 한 번에 가져옴(N 관계를 두 개이상 조회 불가)
//        val users2 = userRepository.findAllWithHistories()
//        assertThat(users2).hasSize(1)
//        assertThat(users2[0].userLoanHistories).hasSize(2)

        // 방법 4 Util로 @Transactional을 감싼 메서드를 실행
//        txHelper.exec {
//            val users = userRepository.findAll()
//            assertThat(users).hasSize(1)
//            assertThat(users[0].userLoanHistories).hasSize(2)
//        }
    }
}