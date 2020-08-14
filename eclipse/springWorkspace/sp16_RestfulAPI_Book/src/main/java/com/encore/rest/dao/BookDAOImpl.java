package com.encore.rest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.encore.rest.vo.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SqlSession sqlSession;
	private String ns = "sql.book.mapper.";
	
	@Override
	public List<Book> getAllBook() throws Exception {
		return sqlSession.selectList(ns+"getAllBook");
	}

	@Override
	public Book getBook(String isbn) throws Exception {
		return sqlSession.selectOne(ns+"getBook",isbn);
	}

	@Override
	public boolean insertBook(Book book) throws Exception {
		return sqlSession.insert(ns+"insertBook",book)==1 ? true:false;
	}

	@Override
	public boolean updateBook(Book book) throws Exception {
		return sqlSession.update(ns+"updateBook",book)==1 ? true:false;
	}

	@Override
	public boolean deleteBook(String isbn) throws Exception {
		return sqlSession.delete(ns+"deleteBook",isbn)==1 ? true:false;
	}

	
}
