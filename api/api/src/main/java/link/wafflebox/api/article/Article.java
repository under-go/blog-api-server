package link.wafflebox.api.article;

import link.wafflebox.api.author.Author;

public class Article {
    private final Long id;
    private final String title;
    private final String summary;
    private final String content;
    private final Author author;

    public Article(Long id, String title, String summary, String content, Author author) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.content = content;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public String getContent() {
        return content;
    }

    public Author getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                '}';
    }
}
