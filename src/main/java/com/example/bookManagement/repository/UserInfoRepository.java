package com.example.bookManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookManagement.entity.UserInfo;

/**
 * Spring Data JPAの使い方
 * ・メソッド名によってクエリを自動生成することができる。
 * ・メソッド名の命名規則は以下の通り。
 * 　　・findBy＋検索条件の項目名＋検索条件の演算子＋検索条件の項目名
 * 　　  例：findBy＋{userId}＋{Like}＋{And}＋{UserStatusKind}
 *          ※検索条件の項目名は、エンティティのフィールド名を指定する。(このファイルではUserInfoエンティティを利用しているため、UserInfoのフィールド名を指定する)
 * 　　・検索条件の演算子は、以下の通り。
 * 　　　　・Is：完全一致
 * 　　　　・Equals：完全一致
 * 　　　　・Like：部分一致
 * 　　　　・GreaterThan：より大きい
 * 　　　　・GreaterThanEqual：以上
 * 　　　　・LessThan：より小さい
 * 　　　　・LessThanEqual：以下
 * 　　　　・Between：範囲指定
 * 　　　　・IsNull：Null
 * 　　　　・IsNotNull：Not Null
 * 　　　　・OrderBy：並び替え
 * 　　　　・Not：否定
 * 　　　　・In：リストの中に含まれる
 * 　　　　・NotIn：リストの中に含まれない
 * 　　　　・StartingWith：前方一致
 * 　　　　・EndingWith：後方一致
 * 　　　　・Containing：部分一致
 * 　　　　・True：True
 * 　　　　・False：False
 * 　　　　・IgnoreCase：大文字小文字を区別しない
 */


/**
 * ユーザ情報テーブルDAO
 *
 * @author shun
 *
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
	/**
	 * ログインIDの部分一致検索を行います。
	 * 
	 * @param userId ログインID
	 * @return 検索でヒットしたユーザー情報のリスト
	 */
	List<UserInfo> findByUserIdLike(String userId);
}
