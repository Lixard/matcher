ALTER TABLE matcher.pictures
    RENAME TO files;
ALTER TABLE matcher.files
    RENAME COLUMN picture_id TO file_id;